package com.garden.life.commons.optimizer;

import com.garden.life.commons.domain.*;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.lang.Class;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 将需要被序列化的实体类注册到dubbo系统中，序列化的性能可能被大大提升
 * </p>
 * @author lenvaco
 * @date 2020/3/29 1:02
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {
	@Override
	public Collection<Class> getSerializableClasses() {
		List<Class> classes = new LinkedList<Class>();
		classes.add(User.class);
            classes.add(Activity.class);
            classes.add(ActivityDetail.class);
            classes.add(ApplyFile.class);
            classes.add(ApplyFileDetail.class);
            classes.add(Book.class);
            classes.add(com.garden.life.commons.domain.Class.class);
            classes.add(CollectionFile.class);
            classes.add(CollectionFileDetail.class);
            classes.add(Faculty.class);
            classes.add(FacultyClass.class);
            classes.add(LostProperty.class);
            classes.add(Menu.class);
            classes.add(Notification.class);
            classes.add(PartTimeJob.class);
            classes.add(Permission.class);
            classes.add(Questionaire.class);
            classes.add(QuestionaireComment.class);
            classes.add(Role.class);
            classes.add(RoleMenu.class);
            classes.add(RoleMenu.class);
            classes.add(RuntimePermission.class);
            classes.add(Ticket.class);
            classes.add(TicketRecord.class);
            classes.add(Vote.class);
            classes.add(VoteDetail.class);
            classes.add(VoteItem.class);

		return classes;
	}
}