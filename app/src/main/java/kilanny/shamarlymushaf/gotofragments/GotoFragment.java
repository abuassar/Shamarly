package kilanny.shamarlymushaf.gotofragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import kilanny.shamarlymushaf.DbManager;
import kilanny.shamarlymushaf.MainActivity;
import kilanny.shamarlymushaf.QuranData;
import kilanny.shamarlymushaf.Setting;

/**
 * Created by Yasser on 12/06/2016.
 */

public abstract class GotoFragment extends Fragment {

    protected QuranData quranData;
    protected DbManager db;
    protected Setting setting;

    protected void fillFields() {
        db = DbManager.getInstance(getContext());
        quranData = QuranData.getInstance(getContext());
        setting = Setting.getInstance(getContext());
    }

    protected void showMainActivity(int page) {
        Context context = getActivity();
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.SHOW_PAGE_MESSAGE,
                page / (setting.lastWasDualPage ? 2 : 1));
        context.startActivity(intent);
    }

    protected void showMainActivity(int page, int sura, int ayah) {
        Context context = getActivity();
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.SHOW_PAGE_MESSAGE,
                page / (setting.lastWasDualPage ? 2 : 1));
        intent.putExtra(MainActivity.SHOW_AYAH_MESSAGE, String.format("%d,%d", sura, ayah));
        context.startActivity(intent);
    }

}
