package com.yupi.project.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;
import com.yupi.project.model.entity.InterfaceInfo;
import com.yupi.project.model.enums.InterfaceInfoStatusEnum;
import com.yupi.project.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2025-03-19 20:57:07
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {
    
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

     Long id = interfaceInfo.getId();
     String name = interfaceInfo.getName();
     String description = interfaceInfo.getDescription();
     String url = interfaceInfo.getUrl();
     String requestHeader = interfaceInfo.getRequestHeader();
     String responseHeader = interfaceInfo.getResponseHeader();
     Integer status = interfaceInfo.getStatus();
     String method = interfaceInfo.getMethod();
     Long userId = interfaceInfo.getUserId();
     Date createTime = interfaceInfo.getCreateTime();
     Date updateTime = interfaceInfo.getUpdateTime();
     Integer isDelete = interfaceInfo.getIsDelete();

        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name, description, url, requestHeader, responseHeader,method)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }

        }
        if (StringUtils.isNotBlank(name) && name.length() > 128) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
        if (StringUtils.isNotBlank(description) && description.length() > 512) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "描述内容过长");
        }
        if (status != null && !InterfaceInfoStatusEnum.getValues().contains(status)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

    }
}




