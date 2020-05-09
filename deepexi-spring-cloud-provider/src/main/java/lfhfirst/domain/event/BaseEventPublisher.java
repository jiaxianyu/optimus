package lfhfirst.domain.event;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

/**
 * 事件推送实体基类
 * 需要被领域实体类继承
 *
 * @author zhengyf
 * @since 2019/12/24
 */
@Slf4j
public class BaseEventPublisher  {
    private EventBus eventBus;

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

}
