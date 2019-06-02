package com.colabo

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TaskUserController {

    TaskUserService taskUserService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond taskUserService.list(params), model:[taskUserCount: taskUserService.count()]
    }

    def show(Long id) {
        respond taskUserService.get(id)
    }

    def create() {
        respond new TaskUser(params)
    }

    def save(TaskUser taskUser) {
        if (taskUser == null) {
            notFound()
            return
        }

        try {
            taskUserService.save(taskUser)
        } catch (ValidationException e) {
            respond taskUser.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'taskUser.label', default: 'TaskUser'), taskUser.id])
                redirect taskUser
            }
            '*' { respond taskUser, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond taskUserService.get(id)
    }

    def update(TaskUser taskUser) {
        if (taskUser == null) {
            notFound()
            return
        }

        try {
            taskUserService.save(taskUser)
        } catch (ValidationException e) {
            respond taskUser.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'taskUser.label', default: 'TaskUser'), taskUser.id])
                redirect taskUser
            }
            '*'{ respond taskUser, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        taskUserService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'taskUser.label', default: 'TaskUser'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'taskUser.label', default: 'TaskUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
