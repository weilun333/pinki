package com.cw.pinki.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "分頁對象")
public class PageResult<T> {
    @Schema(description = "頁碼")
    private int pageNum;

    @Schema(description = "每頁顯示數量")
    private int pageSize;

    @Schema(description = "查詢總數量")
    private int totalRecord;

    @Schema(description = "總頁數")
    private int totalPages;

    @Schema(description = "數據列表")
    private List<T> result;

}
