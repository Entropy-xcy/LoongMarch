package loongmarch

import chisel3._
import chisel3.util._
import chisel3.iotesters._

class RegFilePeekPokeTester(c: RegFile) extends PeekPokeTester(c) {
    // println("Hello World")
    poke(c.io.rj_sel, 1)
    poke(c.io.rk_sel, 2)
    poke(c.io.wr_en, 1)
    poke(c.io.rd_sel, 1)
    poke(c.io.rd_d, 123)
    var rj = peek(c.io.rj_d)
    var rk = peek(c.io.rk_d)
    println(s"rj=$rj, rk=$rk")
    step(1)

    rj = peek(c.io.rj_d)
    rk = peek(c.io.rk_d)
    println(s"rj=$rj, rk=$rk")
}


object RegFileTest extends App {
    chisel3.iotesters.Driver.execute(Array("--backend-name", "verilator", "--full-stacktrace"), () => new RegFile()) { c =>
        new RegFilePeekPokeTester(c)
    }
}
