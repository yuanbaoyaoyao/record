package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.UserOrderService;
import com.yuanbao.record.mbp.mapper.OrderProductMapper;
import com.yuanbao.record.mbp.mapper.UserOrderMapper;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.OrderProductVo;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import com.yuanbao.record.mbp.vomapper.OrderProductVoMapper;
import com.yuanbao.record.mbp.vomapper.UserOrderVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;

    @Override
    public IPage<UserOrderVo> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle, Long orderSn, Integer orderStatus) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListSearch(pageNum, pageSize, page, userId, productTitle, productSkusTitle, orderSn, orderStatus);

        return getUserOrderVoIPage(pageNum, pageSize, voPage, userOrderVoList, userOrderIPage);
    }

    @Override
    public IPage<UserOrderVo> selectOrderListDateSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, Integer dateState, String receiver,Long orderSn, String specifiedTime1, String specifiedTime2) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListDateSearch(pageNum, pageSize, page, userId, receiver,orderSn, dateState, specifiedTime1, specifiedTime2);
        return getUserOrderVoIPage(pageNum, pageSize, voPage, userOrderVoList, userOrderIPage);
    }

    @Override
    public IPage<UserOrderVo> selectOrderListDateCountSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, Integer dateState, String receiver, String specifiedTime1, String specifiedTime2) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListDateCountSearch(pageNum, pageSize, page, userId, receiver, dateState, specifiedTime1, specifiedTime2);
        return getUserOrderVoIPage(pageNum, pageSize, voPage, userOrderVoList, userOrderIPage);
    }

//    @Override
//    public IPage<UserOrderVo> selectProductListDateCountSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, String productTitle, String productSkusTitle, Integer dateState, String specifiedTime1, String specifiedTime2) {
//        page.setCurrent(pageNum);
//        page.setSize(pageSize);
//        IPage<UserOrderVo> voPage = new Page<>();
//        List<UserOrderVo> userOrderVoList = new ArrayList<>();
//        IPage<UserOrder> userOrderIPage = userOrderMapper.selectProductListDateCountSearch(pageNum, pageSize, page, productTitle, productSkusTitle, dateState, specifiedTime1, specifiedTime2);
//        return getUserOrderVoIPage(pageNum, pageSize, voPage, userOrderVoList, userOrderIPage);
//    }

    @Override
    public IPage<UserOrderVo> selectOrderListDateCountSearchNoGroup(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListDateCountSearchNoGroup(pageNum, pageSize, page, userId, receiver, dateState, specifiedTime1, specifiedTime2);
        return getUserOrderVoIPage(pageNum, pageSize, voPage, userOrderVoList, userOrderIPage);
    }

    @Override
    public List<UserOrderVo> selectOrderListDateCountSearchAllList(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2) {
        List<UserOrder> userOrderList= userOrderMapper.selectOrderListDateCountSearchAllList(userId, receiver, dateState, specifiedTime1, specifiedTime2);
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        userOrderToUserOrderVo(userOrderList, userOrderVoList);
        return userOrderVoList;
    }

    @Override
    public List<UserOrderVo> selectOrderListDateCountSearchAllListDay(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2) {
        List<UserOrder> userOrderList= userOrderMapper.selectOrderListDateCountSearchAllListDay(userId, receiver, dateState, specifiedTime1, specifiedTime2);
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        userOrderToUserOrderVo(userOrderList, userOrderVoList);
        return userOrderVoList;
    }

    @Override
    public List<UserOrderVo> selectOrderListDateCountSearchAllListMonth(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2) {
        List<UserOrder> userOrderList= userOrderMapper.selectOrderListDateCountSearchAllListMonth(userId, receiver, dateState, specifiedTime1, specifiedTime2);
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        userOrderToUserOrderVo(userOrderList, userOrderVoList);
        return userOrderVoList;
    }

    private void userOrderToUserOrderVo(List<UserOrder> userOrderList, List<UserOrderVo> userOrderVoList) {
        for (UserOrder userOrder : userOrderList) {
            UserOrderVo userOrderVo = UserOrderVoMapper.userordervomapper.Trans(userOrder);
            Map<String, Integer> data = new TreeMap<>(
//                    降序
                    new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o2.compareTo(o1);
                        }
                    }
            );
            List<OrderProductVo> orderProductVoList = new ArrayList<>();
            List<UserOrder> userOrderList1 = userOrderMapper.selectIdOrderByReceiver(userOrder.getReceiver());
            for (UserOrder userOrder1 : userOrderList1) {
                List<OrderProduct> orderProductList = orderProductMapper.selectOrderProductList(userOrder1.getId(),null, "", "");
                int temp = 0;
                for (OrderProduct orderProduct : orderProductList) {
                    OrderProductVo orderProductVo = OrderProductVoMapper.orderproductvomapper.Trans(orderProduct);
                    orderProductVoList.add(orderProductVo);
                    if (data.get(orderProductVo.getProductSkusTitle()) != null) {
                        temp = data.get(orderProductVo.getProductSkusTitle());
                    }
                    data.put(orderProductVo.getProductSkusTitle(), orderProductVo.getNumber() + temp);
                }
            }
            userOrderVo.setOrderProductVoList(orderProductVoList);
            userOrderVo.setMaxNumSkuName(getKeyOrNull(data));
            System.out.println("userOrderVo.getMaxNumSkuName:"+userOrderVo.getMaxNumSkuName());
            userOrderVoList.add(userOrderVo);
        }
    }

    private IPage<UserOrderVo> getUserOrderVoIPage(Integer pageNum, Integer pageSize, IPage<UserOrderVo> voPage, List<UserOrderVo> userOrderVoList, IPage<UserOrder> userOrderIPage) {
        List<UserOrder> userOrderList = userOrderIPage.getRecords();

        userOrderToUserOrderVo(userOrderList, userOrderVoList);

        voPage.setRecords(userOrderVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(userOrderIPage.getTotal());
        return voPage;
    }

//    获取map中的key
    private static String getKeyOrNull(Map<String, Integer> map) {
        String keyName = null;
        for (Map.Entry<String, Integer> entry :
                map.entrySet()) {
            keyName = entry.getKey();
            if (keyName != null) break;
        }
        return keyName;
    }

//    @Override
//    public int updateByPrimaryKey(UserOrder userOrder) {
//        return userOrderMapper.updateByPrimaryKey(userOrder);
//    }

    @Override
    public int updateByOrderSn(UserOrder userOrder) {
        return userOrderMapper.updateByOrderSn(userOrder);
    }
}
