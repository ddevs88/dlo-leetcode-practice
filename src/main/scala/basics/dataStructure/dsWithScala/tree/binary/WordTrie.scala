package basics.dataStructure.dsWithScala.tree.binary

case class WordTrie[V](children: List[Option[WordTrie[V]]], isLeaf: Boolean) {
  def insert(word: String): WordTrie[V] = WordTrie.insert(this, word, step = 0)
}

object WordTrie{
  def empty[V]: WordTrie[V] = new WordTrie[V](List.fill(26)(None), false)
  def apply[V]: WordTrie[V] = empty

  private def insert[V](node: WordTrie[V], key: String, step: Int): WordTrie[V] =
    if (key.length == step) {
      node
    } else {
      val index    = key.charAt(step) - 97
      val nextItem = node.children(index).getOrElse(WordTrie.empty[V])
      val newNode  = insert(nextItem, key, step + 1)
      val newNext  = node.children.updated(index, Some(newNode))
      println(node.children)
      node.copy(children = newNext, isLeaf = true)
    }
}

object WordTrieApp extends App{
  val list = List("the", "a", "there", "answer", "any", "by", "bye", "their")
  val node = WordTrie[String]
    .insert("add")
    .insert("bad")
}
