/*
 __AUTHOR__: Juan Alejandro Alcantara Minaya
 __STUDENT ID__: A01703947
 __PROBLEM #:__ 24 & 46
 */
import kotlin.random.Random

// PROBLEM 24
fun lotto(n: Int, max_val: Int): List<Int> {
    var result : List<Int> = emptyList();
    var previous_selections : BooleanArray = BooleanArray(max_val+1, {false});
    var i : Int = 0;
    while(i < n){
        var index : Int = Random.nextInt(1, max_val);
        if(!previous_selections[index]) {
            previous_selections[index] = true;
            result += index;
            i++;
        }
    }
    return result;
}


// PROBLEM 46
fun Boolean.not_() = !this;
fun Boolean.and_(other : Boolean) = this && other;
fun Boolean.or_(other : Boolean) = this || other;
fun Boolean.nand_(other : Boolean) = !(this && other);
fun Boolean.nor_(other : Boolean) = !(this || other);
fun Boolean.xor_(other : Boolean) = this != other;
fun Boolean.impl_(other : Boolean) = this == other || !this && other;
fun Boolean.equ_(other : Boolean) = this == other;
fun Int.toBool() = this > 0;

fun printTruthTable(f: (Boolean, Boolean) -> Boolean){
    println("a   | b    | result");
    for(i in 1 downTo 0){
        for(j in 1 downTo 0){
            println("""${i.toBool()} | ${j.toBool()} | ${f(i.toBool(), j.toBool())}""")
        }
    }
    println();
}


// # TESTS CASES
// ## PROBLEM 24
// ### GitHub defined
println(lotto(3, 49))
// ### User defined
println(lotto(10,99))
println(lotto(5,1337))
println()


// ## PROBLEM 46
// ### GitHub defined
printTruthTable{ a, b -> a.and_(a.or_(b.not_())) }
// ### User defined
printTruthTable{ a, b -> a.and_(b).not() }
printTruthTable{ a, b -> b.not_().or_(a.not_()) }
