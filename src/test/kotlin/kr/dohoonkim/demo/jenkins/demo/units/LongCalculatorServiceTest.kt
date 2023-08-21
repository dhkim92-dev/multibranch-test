package kr.dohoonkim.demo.jenkins.demo.units

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kr.dohoonkim.demo.jenkins.demo.LongCalculatorService
import java.lang.ArithmeticException

class LongCalculatorServiceTest : BehaviorSpec({

    val longCalculatorService = LongCalculatorService()

    Given("0이 아닌 두 Long 타입 정수가 주어졌을 때") {
        val a = 1L
        val b = 2L

        When("더하기를 하면") {
            Then("더한 값이 반환된다.") {
                longCalculatorService.plus(a, b) shouldBe 3L
            }
        }

        When("빼기를 하면") {
            Then("뺀 값이 반환된다.") {
                longCalculatorService.minus(a, b) shouldBe -1L
            }
        }

        When("나눗셈을 하면") {
            Then("나눈 값이 Double형으로 반환된다."){
                val ret : Double = a / b.toDouble()
                longCalculatorService.div(a, b) shouldBe  ret
            }
        }

        When("곱셈을 하면") {
            Then("곱한 값이 반환된다.") {
                longCalculatorService.mul(a, b) shouldBe a*b
            }
        }
    }

    Given("나누는 값이 0으로 주어진다.") {
        When("나눗셈을 하면") {
            Then("에러가 발생한다.") {
                shouldThrow<ArithmeticException> {
                    longCalculatorService.div(3L, 0L)
                }
            }
        }
    }

})