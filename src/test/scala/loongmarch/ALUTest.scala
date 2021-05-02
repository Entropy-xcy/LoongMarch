package loongmarch

import chisel3._
import chisel3.util._
import chisel3.iotesters._

class ALUPeekPokeTester(c: ALU) extends PeekPokeTester(c) {
    println("Hello World")
}


object ALUTest extends App {
    chisel3.iotesters.Driver.execute(Array("--backend-name", "verilator", "--full-stacktrace"), () => new ALU()) { c =>
        new ALUPeekPokeTester(c)
    }
}
