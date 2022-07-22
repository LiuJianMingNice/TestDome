package com.example.pdfhelper.rspdfview.interfaces;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * IPDFControl
 *
 * @author liujianming
 * @date 2022-07-20
 */
public interface IPDFControl {

    void addPDFOperateListener(IPDFOperateListener listener);

    void setThePageNumber(String number);
}
