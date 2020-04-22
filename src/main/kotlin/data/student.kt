package data

data class Student (
    val firstname: String,
    val surname: String,
    var check: Boolean
)

val studentList =
    arrayListOf(
        Student("Max", "Shanin",true),
        Student("Sheldon", "Cooper",true),
        Student("Leonard", "Hofstadter",true),
        Student("Howard", "Wolowitz",true)
    )