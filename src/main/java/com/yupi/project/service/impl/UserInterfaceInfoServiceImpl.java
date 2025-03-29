package com.yupi.project.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.model.entity.UserInterfaceInfo;
import com.yupi.project.service.UserInterfaceInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【user_interface_info(用户接口信息关系)】的数据库操作Service实现
 * @createDate 2025-03-29 21:29:38
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        Integer status = userInterfaceInfo.getStatus();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        if (add) {
            if (ObjectUtils.anyNull(userId, interfaceInfoId)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }

        if (totalNum < 0 || leftNum < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "次数不能小于0");
        }


    }
}




