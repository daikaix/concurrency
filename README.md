# concurrency
Java多线程学习
1. 并发模拟
    1. Postman模拟并发
    2. Apache AB压力测试工具
    3. JMeter
    4. 代码方式
2. 线程安全性：多个线程不管以何种方式访问某个类，并且在主调代码中不需要进行同步，都能表现正确的行为。
3. 非阻塞同步：先进行操作，如果未发生其他线程争用的情况就操作成功，否则重试，这种方案不需要阻塞。
         乐观的锁，但是不适合高强度竞争的情况
    1. Atomic包，原子性 AutomicInteger
    2. AtomicLong，LongAdder，AtomicReference<Integer>，AtomicIntegerFieldUpdater<AtomicExample5>，AtomicLongArray，AtomicBoolean
    3. 原理:CAS：CompareAndSwap,比较并交换。
    4. ABA问题，AtomicStampedReference
4. 互斥同步
    1. synchronized:（不可中断锁，适合竞争不激烈)
    2. Lock：可中断锁，多样化同步，竞争激烈维持常态
5. 安全发布对象  （在对象构建之前不能发布对象，可变对象需要安全发布），结合互斥同步实现多线程安全发布对象
6. 不可变对象
7. 线程封闭
