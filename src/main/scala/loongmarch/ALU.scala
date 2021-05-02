package loongmarch

import chisel3._
import chisel3.util._
import Configs._
import Consts._

class ALU extends Module{
    val io = IO(new Bundle{
        val aluop = Input(UInt(aluop_width.W))
        val a     = Input(UInt(BUS_WIDTH.W))
        val b     = Input(UInt(BUS_WIDTH.W))
        val out   = Output(UInt(BUS_WIDTH.W))
    })

    io.out := MuxCase(0.U, Array(
                (io.aluop === aluops.add) -> (io.a + io.b),
                (io.aluop === aluops.and) -> (io.a & io.b),
                (io.aluop === aluops.sub) -> (io.a - io.b)
    ))

}
