package com.colabo

class TaskUser {

    User assignee
    Task task

    Date dateCreated
    Date lastUpdated

    static constraints = {
        assignee unique: ['task']
    }
}
