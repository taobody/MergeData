# MergeDataソフト作成　備忘録

#### 2020.6.5
テキストファイル（レーザーデータログ、約7分の走行で612万行程度のもの）を読み込み中に、OutOfMemoryError が発生。
未解決。
試したこと：
 - 従来のBufferedReader、FileReaderを使用したもの
 - newBufferedReaderを使用したもの
 - BufferedReader、InputStreamReader、FileInputStreamを使用したもの

このうち、二つ目はアクセス拒否された。