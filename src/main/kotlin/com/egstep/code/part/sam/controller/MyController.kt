package com.egstep.code

import com.egstep.code.part.sam.service.OneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/my")
class MyController {

    @Autowired lateinit var service: OneService
    @Autowired lateinit var ctx: ApplicationContext

    @Value("\${app.name}")lateinit var appName: String

    @GetMapping
    fun main(): ModelAndView {
        val mv = ModelAndView()
        mv.viewName = "abc"

        mv.addObject("user", User(name="junghoon"))

        return mv
    }

    @GetMapping("/sample")
    fun sample(): String{
        return appName
    }
}

data class User(
    val name: String
)
