package kr.dohoonkim.demo.jenkins.demo.units

import com.ninjasquad.springmockk.MockkBean
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kr.dohoonkim.demo.jenkins.demo.LongCaculatorController
import kr.dohoonkim.demo.jenkins.demo.LongCalculatorService
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import java.lang.ArithmeticException

class LongCalculatorControllerTest : BehaviorSpec({
    val longCaculatorService = LongCalculatorService()
    val longCalculatorController = LongCaculatorController(longCaculatorService)

    Given("두개의 0이 아닌 정수가 주어진다.") {
        val a = 2L
        val b = -3L
        When("덧셈을 하면") {
            Then("더한 값이 반환된다.") {
                val response = longCalculatorController.plus(a ,b)

                response.statusCode shouldBe  HttpStatus.OK
                response.body shouldBe -1L
            }
        }

        When("뺄셈을 하면") {
            Then("뺀 값이 반환된다.") {
                val response = longCalculatorController.minus(a, b)

                response.statusCode shouldBe  HttpStatus.OK
                response.body shouldBe 5L
            }
        }

        When("곱셈을 하면") {
            Then("곱한 값이 반환된다.") {
                val response = longCalculatorController.multiply(a, b)

                response.statusCode shouldBe  HttpStatus.OK
                response.body shouldBe -6L
            }
        }

        When("나눗셈을 하면") {
            Then("나눈 값이 반환된다.") {
                val response = longCalculatorController.div(a, b)

                response.statusCode shouldBe  HttpStatus.OK
                response.body shouldBe a/b.toDouble()
            }
        }
    }

    Given("b가 0으로 주어지고") {
        When("나눗셈을 하면") {
            Then("에러가 발생한다.") {
                shouldThrow<ArithmeticException> {
                    longCalculatorController.div(1L, 0L)
                }
            }
        }
    }
})