package com.javazx.batch.extend.processor;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author itmrchen
 * @date 2016/10/12
 * @time 13:19
 */
public class UserItemProcessor implements ItemProcessor<Object, Object> {

	public Object process(Object result) throws Exception {
		return result;
	}

}
