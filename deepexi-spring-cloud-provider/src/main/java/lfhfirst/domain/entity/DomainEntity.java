package lfhfirst.domain.entity;

import lfhfirst.domain.event.BaseEventPublisher;

/**
 * 领域实体基类
 *
 * @author zhengyf
 * @since 2019/12/24
 */
public class DomainEntity<T> extends BaseEventPublisher {
    private T id;

    public T getId() {
        return id;
    }

    public DomainEntity(T id) {
        this.id = id;
    }
}
