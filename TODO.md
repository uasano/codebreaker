# CodeBreaker実装

* [ ] 答えを作る
* [x] 入力された値が答えと一致するか判定する
  * [x] 入力値が答えと一致してたら正解と判定する
  * [x] ~~入力の桁数が3以外だった場合は？~~ 特に考慮しないことにする
  * [x] 答えで渡された桁数が3以外だった場合は？
  * [x] 答えで渡された文字列がnullだった場合は？(後回し)
  * [x] 答えで渡された文字列に数字以外が含まれた場合は？ (後回し)
  * [x] 入力値がnullだった場合は、NullPointerException.
* [x] 入力された値と答えを比較してヒントを出す
  * [x] ◯(数字と位置が一致する)の数を出す
  * [x] △(数字は合ってるけど位置が違う)の数を出す
  * [x] Hit と Blow を1つのメソッドで返す
  * [x] 入力値のチェック(null, 桁数不一致) -> IllegalArgumentException.
* [x] 答えが一致してるか、ヒント は全部1つのメソッドが返すようにする