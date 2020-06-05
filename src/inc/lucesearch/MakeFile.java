package inc.lucesearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MakeFile {


	static String mergeFiles(
			String encLogFilePath,
			String lidarLogFilePath,
			boolean selectedBtn) {

		String mergeResult = "結合終了！";
		/*
		System.out.println("ファイルを結合します");
		System.out.println("エンコーダーファイルパス：" + encLogFilePath);
		System.out.println("レーザーファイルパス：" + lidarLogFilePath);
		System.out.println("結合基準：" + selectedBtn);
		 */

		// 結合ファイル名の生成
		String mergedFileName = makeFileName(encLogFilePath);
		System.out.println(mergedFileName);

		// ログデータのリスト化
		List<String> lstEncLog = makeList(encLogFilePath);
		System.out.println("エンコーダーデータ　：" + lstEncLog.size());

		List<String> lstLidarLog = makeList(lidarLogFilePath);
		System.out.println("レーザーデータ　：" + lstLidarLog.size());


		return mergeResult;
	}

	static String separateFiles(
			String targetFile,
			String sepPitch,
			String sepOffset) {
		String sepResult = "分割終了！";
		System.out.println("ファイルを分割します");

		return sepResult;
	}

	// 結合ファイル名の生成メソッド
	private static String makeFileName(String encLogFile) {

		String parentDir = new File(encLogFile).getParent();

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = sdf.format(date);

		String mergedFileName = parentDir + File.separator + timestamp + "_treated.csv";

		return mergedFileName;
	}

	private static List<String> makeList(String logFilePath) {

		List<String> logList = new ArrayList<>();
		long count = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(logFilePath)))){
//			String pointsData;

			//	BufferedReader br = new BufferedReader(new FileReader(logFilePath));
			for(String pointsData = null; (pointsData = br.readLine()) != null;) {
				logList.add(pointsData);
				System.out.println(count);
				count++;
			}
			/*
			 * ここで OutOfMemoryError が発生する
			 */
//			while ((pointsData = br.readLine()) != null) {
//				logList.add(pointsData);
//				System.out.println(count);
//				count++;
//			}

		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりません");
		} catch (IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return logList;
	}
}

