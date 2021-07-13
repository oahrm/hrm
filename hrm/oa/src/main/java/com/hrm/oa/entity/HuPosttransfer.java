package com.hrm.oa.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工调岗记录表(HuPosttransfer)实体类
 *
 * @author makejava
 * @since 2021-07-13 20:11:14
 */
public class HuPosttransfer implements Serializable {
    private static final long serialVersionUID = -82565001045923103L;

    private String transferId;

    private String transferName;

    private String primaryDept;

    private String primaryStation;

    private String newDept;

    private String newStation;

    private Date transferData;

    private Integer transferState;


    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public String getTransferName() {
        return transferName;
    }

    public void setTransferName(String transferName) {
        this.transferName = transferName;
    }

    public String getPrimaryDept() {
        return primaryDept;
    }

    public void setPrimaryDept(String primaryDept) {
        this.primaryDept = primaryDept;
    }

    public String getPrimaryStation() {
        return primaryStation;
    }

    public void setPrimaryStation(String primaryStation) {
        this.primaryStation = primaryStation;
    }

    public String getNewDept() {
        return newDept;
    }

    public void setNewDept(String newDept) {
        this.newDept = newDept;
    }

    public String getNewStation() {
        return newStation;
    }

    public void setNewStation(String newStation) {
        this.newStation = newStation;
    }

    public Date getTransferData() {
        return transferData;
    }

    public void setTransferData(Date transferData) {
        this.transferData = transferData;
    }

    public Integer getTransferState() {
        return transferState;
    }

    public void setTransferState(Integer transferState) {
        this.transferState = transferState;
    }

}
