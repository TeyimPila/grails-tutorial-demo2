package com.colabo

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TaskUserServiceSpec extends Specification {

    TaskUserService taskUserService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TaskUser(...).save(flush: true, failOnError: true)
        //new TaskUser(...).save(flush: true, failOnError: true)
        //TaskUser taskUser = new TaskUser(...).save(flush: true, failOnError: true)
        //new TaskUser(...).save(flush: true, failOnError: true)
        //new TaskUser(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //taskUser.id
    }

    void "test get"() {
        setupData()

        expect:
        taskUserService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TaskUser> taskUserList = taskUserService.list(max: 2, offset: 2)

        then:
        taskUserList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        taskUserService.count() == 5
    }

    void "test delete"() {
        Long taskUserId = setupData()

        expect:
        taskUserService.count() == 5

        when:
        taskUserService.delete(taskUserId)
        sessionFactory.currentSession.flush()

        then:
        taskUserService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TaskUser taskUser = new TaskUser()
        taskUserService.save(taskUser)

        then:
        taskUser.id != null
    }
}
