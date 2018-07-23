package com.zhuziym.char03.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月23日 下午3:13:20 克隆工具类
 */
public class CloneUtils {
	public static <T extends Serializable> T clone(T obj) {

		// 拷贝产生的对象
		T clonedObj = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oss = new ObjectOutputStream(baos);
			oss.writeObject(obj);
			oss.close();

			// 分配内存空间，写入原始对象，生成新对象
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);

			// 返回新对象 并做类型转换
			clonedObj = (T) ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clonedObj;
	}

	private void mian() {

	}
}
