package com.rallydev.intellij.wsapi.queries

import com.rallydev.intellij.RallyTaskFactory
import com.rallydev.intellij.wsapi.ApiResponse
import com.rallydev.intellij.wsapi.GetRequest
import com.rallydev.intellij.wsapi.RallyClient
import spock.lang.Specification

class FilteredTasksQuerySpec extends Specification {

    def "findTasks query"() {
        given:
        GroovySpy(RallyTaskFactory, global: true)
        2 * RallyTaskFactory.tasksFromResponse(_ as ApiResponse) >> { a -> [] }

        and: 'Mock a client that records requests'
        RallyClient client = Mock(RallyClient)
        List<String> requests = []
        client.makeRequest(_ as GetRequest) >> { GetRequest request ->
            requests << request.getUrl(''.toURI())
            return new ApiResponse('')
        }

        and:
        FilteredTasksQuery query = new FilteredTasksQuery(client)

        when:
        query.findTasks('someQuery', 50)

        then: 'Check that proper requests were made'
        requests.contains('/slm/webservice/1.39/hierarchicalrequirement.js?fetch=true&pagesize=50&query=(Name contains "someQuery")')
        requests.contains('/slm/webservice/1.39/defect.js?fetch=true&pagesize=50&query=(Name contains "someQuery")')
    }

}
