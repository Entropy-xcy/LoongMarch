package loongmarch

import chisel3._
import chisel3.util._
import loongmarch.Configs._

class RegFile extends Module{
    val io = IO(new Bundle{
        val rk_sel = Input(UInt(log2Ceil(REG_COUNTS).W))
        val rj_sel = Input(UInt(log2Ceil(REG_COUNTS).W))
        val rk_d   = Output(UInt(BUS_WIDTH.W))
        val rj_d   = Output(UInt(BUS_WIDTH.W))

        val rd_sel = Input(UInt(log2Ceil(REG_COUNTS).W))
        val rd_d   = Input(UInt(BUS_WIDTH.W))

        val wr_en  = Input(Bool())
    })

    val regfile = Reg(Vec(REG_COUNTS, UInt(BUS_WIDTH.W)))

    // Read
    io.rk_d := regfile(io.rk_sel)
    io.rj_d := regfile(io.rj_sel)

    // Write
    when(io.wr_en){
        regfile(io.rd_sel) := io.rd_d
    }
}
