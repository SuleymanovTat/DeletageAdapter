package com.example.newspaperapplication.ui.pagination;

import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;

import com.example.newspaperapplication.ui.model.DiffItem;
import com.example.newspaperapplication.ui.model.Man;
import com.example.newspaperapplication.ui.model.Woman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SampleDataSource extends PositionalDataSource<DiffItem> {

    private Random random = new Random();

    private List<DiffItem> nextPage(int size) {
        List<DiffItem> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {

            int itemType = random.nextInt(2);
            switch (itemType) {
                case 0:
                    result.add(new Man(1L, "Man " + i, "Cat"));
                    break;

                case 1:
                    result.add(new Woman(2L, "Woman " + i, "Cat"));
                    break;
                default:
                    throw new IllegalStateException("Random returned " + itemType);
            }
        }

        return result;
    }

    @Override
    public void loadInitial(LoadInitialParams params, LoadInitialCallback<DiffItem> callback) {
        List<DiffItem> displayableItems = nextPage(params.requestedLoadSize);
        Log.d("PaginationSource", "pagesize " + params.pageSize + " placeholder " + params.placeholdersEnabled + " requested " + params.requestedLoadSize + " startpos " + params.requestedStartPosition);
        callback.onResult(displayableItems, 0, 200);
    }

    @Override
    public void loadRange(LoadRangeParams params, @NonNull LoadRangeCallback<DiffItem> callback) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log.e("my", "xxx " +e.getMessage());
        }
        List<DiffItem> displayableItems = nextPage(params.loadSize);
        Log.d("PaginationSource", "loadSize " + params.loadSize + " startPosition " + params.startPosition);
        callback.onResult(displayableItems);
    }


    public static class Factory extends DataSource.Factory<Integer, DiffItem> {
        @Override
        public DataSource<Integer, DiffItem> create() {
            return new SampleDataSource();
        }
    }
}