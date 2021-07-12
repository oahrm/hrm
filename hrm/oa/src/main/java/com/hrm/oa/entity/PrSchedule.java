package com.hrm.oa.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * pr_schedule
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class PrSchedule implements Serializable {
    private String scId;

    private String tId;

    private String scContent;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date scDate;

    private String scEId;

    private static final long serialVersionUID = 1L;
}