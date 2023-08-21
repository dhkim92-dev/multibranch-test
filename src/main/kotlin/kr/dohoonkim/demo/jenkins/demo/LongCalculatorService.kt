package kr.dohoonkim.demo.jenkins.demo

import org.springframework.stereotype.Service

@Service
class LongCalculatorService {
    fun plus(a : Long, b : Long) = a + b

    fun minus(a : Long, b : Long) = a - b

    fun div(a : Long, b : Long) : Double {
        if(b == 0L) throw ArithmeticException("Can not divide by zero")

        return a/(b.toDouble())
    }
    fun mul(a : Long, b : Long) = a * b

}