import java.util.*

fun main(args:Array<String>){
    val sc : Scanner = Scanner(System.`in`)

    do{
        var num1 = sc.nextInt()
        var num2 = sc.nextInt()
        var num3 = sc.nextInt()

        if((num1==0)&&(num2==0)&&(num3==0)){
            break
        }
        else{
            var p = ComparePots(num1,num2,num3)
            isTriangle(p.num1,p.num2,p.num3)
        }
    }while (1<2)

}

fun isTriangle(num1: Int ,num2: Int, num3 : Int){
    var arr = arrayListOf<Int>(num1,num2,num3)
    arr.sort()
    if((arr.get(2)*arr.get(2)) == (arr.get(0)*arr.get(0)) + (arr.get(1)*arr.get(1))){
        println("right")
    }
    else{
        println("wrong")
    }
}


open class ComparePots(num1: Int,num2: Int,num3: Int) {
    var num1: Int = num1
    var num2: Int = num2
    var num3: Int = num3
}