package com.garden.life.commons.optimizer;

import com.garden.life.commons.domain.User;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenvaco
 * @date 2020/3/29 1:02
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {
	@Override
	public Collection<Class> getSerializableClasses() {
		List<Class> classes = new LinkedList<Class>();
		classes.add(User.class);
		return classes;
	}
}