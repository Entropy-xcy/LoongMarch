# LoongMarch: a Micro implementation for LoongArch32 ISA
# 长征：32位龙芯构架的微型实现

## 构架详情
* 本实现针对龙芯构架32位精简版，请参照[《龙芯构架32位精简版参考手册》](http://www.loongson.cn/uploadfile/cpu/LoongsonArch32.pdf)
* 本实现目前仅针对无mmu无特权指令集的简易嵌入式应用
* 中断系统将被不完整实现
* 内存系统为纯SRAM组成的Scratchpad，指令内存和数据内存分离。
* 无Cache，PRELD指令将会被忽略。
* 读写遵守Sequential Consistency，栅障指令将会被忽略。
* 不支持由原子指令触发的线程切换。
* 综上所述，本实现**不包含**以下指令集：
    * 浮点指令集
    * 特权指令集
    * 原子指令，栅障指令以及PRELD指令（执行该些指令不会产生异常中断但是也不会产生任何效果）
    * CSR操作指令
    * 某些高级中断指令
    * 调试系统以及调试指令集  
    * 二进制翻译拓展（LBT）
    * 向量拓展（LSX）
    * 高级向量拓展（LASX）
    * 虚拟化拓展（LVZ）
    