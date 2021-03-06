package com.practice.bfs;

/**
 * BFS 广度优先遍历.一层一层的遍历，需要使用队列记录每层的数据.
 * 当前层遍历完了,即当前层出队列完毕(下一层也添加完毕),队列中的头就是下一层需要开始遍历的节点
 * <p>
 * Tree BFS: root添加进队列，一层层遍历.
 * 图的遍历:
 * 有多个源点
 * 图需要保存访问状态
 * 为防止多次入队列,则在入队列前标志位已访问
 */