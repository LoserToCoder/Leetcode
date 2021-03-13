package com.leetcode.async;

import java.util.concurrent.CompletableFuture;

public class AsyncUtil {

    /**
     * CompletableFuture:
     * 如何理解 CompletionStage 接口我觉得，你可以站在分工的角度类比一下工作流。
     * 任务是有时序关系的，比如有串行关系、并行关系、汇聚关系等。
     * 串行关系：
     *   CompletionStage 接口里面描述串行关系，主要是 thenApply、thenAccept、thenRun 和 thenCompose 这四个系列的接口。
         CompletionStage<R> thenApply(fn);
         CompletionStage<R> thenApplyAsync(fn);
         CompletionStage<Void> thenAccept(consumer);
         CompletionStage<Void> thenAcceptAsync(consumer);
         CompletionStage<Void> thenRun(action);
         CompletionStage<Void> thenRunAsync(action);
         CompletionStage<R> thenCompose(fn);
         CompletionStage<R> thenComposeAsync(fn);
       AND 汇聚关系：
         CompletionStage 接口里面描述 AND 汇聚关系，主要是 thenCombine、thenAcceptBoth 和 runAfterBoth 系列的接口，
         这些接口的区别也是源自 fn、consumer、action 这三个核心参数不同。

         CompletionStage<R> thenCombine(other, fn);
         CompletionStage<R> thenCombineAsync(other, fn);
         CompletionStage<Void> thenAcceptBoth(other, consumer);
         CompletionStage<Void> thenAcceptBothAsync(other, consumer);
         CompletionStage<Void> runAfterBoth(other, action);
         CompletionStage<Void> runAfterBothAsync(other, action);
       OR 汇聚关系：
         CompletionStage 接口里面描述 OR 汇聚关系，主要是 applyToEither、acceptEither 和 runAfterEither 系列

         CompletionStage applyToEither(other, fn);
         CompletionStage applyToEitherAsync(other, fn);
         CompletionStage acceptEither(other, consumer);
         CompletionStage acceptEitherAsync(other, consumer);
         CompletionStage runAfterEither(other, action);
         CompletionStage runAfterEitherAsync(other, action);
       异常处理：
         上面我们提到的 fn、consumer、action 它们的核心方法都不允许抛出可检查异常，但是却无法限制它们抛出运行时异常，
         CompletionStage 接口给我们提供的方案非常简单，比 try{}catch{}还要简单，下面是相关的方法，使用这些方法进行异常处理和串行操作是一样的，
         都支持链式编程方式


         CompletionStage exceptionally(fn);
         CompletionStage<R> whenComplete(consumer);
         CompletionStage<R> whenCompleteAsync(consumer);
         CompletionStage<R> handle(fn);
         CompletionStage<R> handleAsync(fn);
     */
    public static void main(String[] args) {
        CompletableFuture future = new CompletableFuture();
    }

}
