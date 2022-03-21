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

import java.time.LocalDateTime;
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
    public IPage<UserOrderVo> selectOrderListDateSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, Integer dateState, String receiver, LocalDateTime specifiedTime1, LocalDateTime specifiedTime2) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListDateSearch(pageNum, pageSize, page, userId, receiver, dateState, specifiedTime1, specifiedTime2);
        return getUserOrderVoIPage(pageNum, pageSize, voPage, userOrderVoList, userOrderIPage);
    }

    private IPage<UserOrderVo> getUserOrderVoIPage(Integer pageNum, Integer pageSize, IPage<UserOrderVo> voPage, List<UserOrderVo> userOrderVoList, IPage<UserOrder> userOrderIPage) {
        List<UserOrder> userOrderList = userOrderIPage.getRecords();

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
                System.out.println("userOrder1:" + userOrder1.getId());
                List<OrderProduct> orderProductList = orderProductMapper.selectOrderProductList(userOrder1.getId(), "", "");
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
            userOrderVoList.add(userOrderVo);
            System.out.println("data:" + getKeyOrNull(data));
        }

        voPage.setRecords(userOrderVoList);
        System.out.println("voPage.getRecords" + voPage.getRecords());
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(userOrderIPage.getTotal());
        return voPage;
    }

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
