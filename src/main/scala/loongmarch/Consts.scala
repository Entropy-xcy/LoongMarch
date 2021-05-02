package loongmarch

import chisel3._
import chisel3.util._

object Consts {
    val aluop_width = 5
    val aluops = ALUOps
}

object ALUOps{
    val add = 0.U
    val sub = 1.U
    val slt = 2.U
    val sltu = 3.U
    val nor = 4.U
    val and = 5.U
    val or = 6.U
    val xor = 7.U
    val sll = 8.U
    val srl = 9.U
    val sra = 10.U
    val a = 11.U
    val b = 12.U
}


