package algorithem

import java.io.File

class Utils {

    fun isValidPhoneNumber(number: String): Boolean {
        if (number.isEmpty()){
            return false
        }
        val regex = Regex("^[6-9][0-9]{9}$")
        return regex.matches(number)
    }

    fun processCsvFile(filePath: String) {
        val invalidNumbers = mutableMapOf<String, String>()
        val validNumbers = mutableMapOf<String, String>()

        val file = File(filePath)
        if (!file.exists()) {
            println("File not found: $filePath")
            return
        }

        file.useLines { lines ->
            lines.drop(1).forEach { line ->  // Skipping the header
                val columns = line.split(",")
                if (columns.size == 2) {
                    val name = columns[0].trim()
                    val mobile = columns[1].trim()
                    if (!isValidPhoneNumber(mobile)) {
                        invalidNumbers[mobile] = name
                    } else {
                        validNumbers[mobile] = name
                    }
                } else {
//                    println("Invalid line format: $line")
                }
            }
        }

        println("Invalid Numbers:")
        invalidNumbers.forEach { (mobile, name) ->
            println("Farmer: $name, Mobile: $mobile, Length: ${mobile.length}")
        }

        /*println("\nValid Numbers:")
        validNumbers.forEach { (mobile, name) ->
            println("Farmer: $name, Mobile: $mobile, Length: ${mobile.length}")
        }*/
    }
}

fun main() {
    val utils = Utils()
    val number : String? = null
//    val filePath = "C:\\Users\\ac928\\Downloads\\All Farmers(sheet1).csv"
//    utils.processCsvFile(filePath)
    println(utils.isValidPhoneNumber(number.toString()))


}
