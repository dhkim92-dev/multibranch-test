package kr.dohoonkim.demo.jenkins.demo

import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("long-calculator/")
class LongCaculatorController(private val longCalculatorService: LongCalculatorService){
    @GetMapping("plus")
    fun plus(@RequestParam() a : Long, b : Long) : ResponseEntity<Long> {
        return ResponseEntity(longCalculatorService.plus(a, b), OK)
    }
    @GetMapping("minus")
    fun minus(@RequestParam() a : Long, b : Long) : ResponseEntity<Long>{
        return ResponseEntity(longCalculatorService.minus(a, b), OK)
    }

    @GetMapping("div")
    fun div(@RequestParam a : Long, b : Long) : ResponseEntity<Double> {
        return ResponseEntity(longCalculatorService.div(a, b), OK)
    }
    @GetMapping("multiply")
    fun multiply(@RequestParam a : Long, b : Long) : ResponseEntity<Long> {
        return ResponseEntity(longCalculatorService.mul(a, b), OK)
    }

}