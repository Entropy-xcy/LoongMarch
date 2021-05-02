package loongmarch

import chisel3._
import chisel3.util._

class InsType_3R extends Bundle{
    val opcode = UInt(17.W)
    val rk_sel = UInt(5.W)
    val rj_sel = UInt(5.W)
    val rd_sel = UInt(5.W)
}

object InsType_3R{
    def fromIns(ins: UInt): InsType_3R = {
        val ins3r = Wire(new InsType_3R)
        ins3r.opcode := ins(31, 10)
        ins3r.rd_sel := ins(4, 0)
        ins3r.rj_sel := ins(9, 5)
        ins3r.rk_sel := ins(14, 10)
        ins3r
    }
}
