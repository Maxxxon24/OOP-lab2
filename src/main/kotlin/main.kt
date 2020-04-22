import data.Student
import data.studentList
import kotlinx.html.H1
import kotlinx.html.LI
import kotlinx.html.dom.append
import kotlinx.html.js.h1
import kotlinx.html.js.li
import kotlinx.html.js.ol
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.dom.clear


var ascending = true

fun main() {
    document.getElementById("root")!!
        .append {
            h1 {
                +"Students"
                onClickFunction = onCLickFunction()
            }
            ol {
                attributes += "id" to "listStudents"
                studentList.map {
                    li {
                        attributes += "id" to it.firstname
                        attributes += "style" to "color:grey"
                        onClickFunction = checkFun(it)
                        +"${it.firstname} ${it.surname}"

                    }
                }
            }
        }
}


private fun H1.onCLickFunction(): (Event) -> Unit {
    return {
        val listStudents = document.getElementById("listStudents")!!
        listStudents.clear()
        listStudents.append {
            if (ascending)
                studentList.sortBy { it.firstname }
            else
                studentList.sortByDescending { it.firstname }
            ascending = !ascending
            studentList.map {
                li {
                    +"${it.firstname} ${it.surname}"
                }
            }
        }
    }
}

private fun LI.checkFun(it: Student): (Event) -> Unit {
    return {event ->
        val student = document.getElementById(it.firstname)!!
        if (it.check) {
            student.setAttribute("style", "color:green")
            it.check = false
        } else {
            student.setAttribute("style", "color:grey")
            it.check = true
        }
    }
}
