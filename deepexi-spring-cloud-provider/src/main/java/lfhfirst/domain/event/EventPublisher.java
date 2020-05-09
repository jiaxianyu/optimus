package lfhfirst.domain.event;

/**
 * 定义事件发布对象实体
 *
 * @author zhengyf
 * @since 2019/12/24
*/
public interface EventPublisher {

    /**
     * 事件发布
     * @param event
     */
    void publish(Event event);

}
