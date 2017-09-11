package com.l.z.common.biz;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IDemoWs {

	void testDemo(@WebParam String jsonStr);
}
