package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.Announcement;
import com.yuanbao.record.mbp.vo.AnnouncementVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnnouncementVoMapper {
    AnnouncementVoMapper announcementvomapper = Mappers.getMapper(AnnouncementVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "announcement.id"),
            @Mapping(target = "title", source = "announcement.title"),
            @Mapping(target = "content", source = "announcement.content"),
            @Mapping(target = "createdAt", source = "announcement.createdAt"),
    })
    AnnouncementVo Trans(Announcement announcement);
}
