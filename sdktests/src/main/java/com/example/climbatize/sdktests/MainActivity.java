package com.example.climbatize.sdktests;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import com.ant_robot.mfc.api.pojo.Collection;
import com.ant_robot.mfc.api.pojo.ItemList;
import com.ant_robot.mfc.api.pojo.PictureGallery;
import com.ant_robot.mfc.api.pojo.SearchResult;
import com.ant_robot.mfc.api.pojo.UserProfile;
import com.ant_robot.mfc.api.request.MFCRequest;
import com.ant_robot.mfc.api.request.service.ItemDate;

import java.util.Date;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            final TextView textView = (TextView) rootView.findViewById(R.id.textView);
            final Button button0 = (Button) rootView.findViewById(R.id.button);
            final Button button1 = (Button) rootView.findViewById(R.id.button1);
            final Button button2 = (Button) rootView.findViewById(R.id.button2);
            final Button button3 = (Button) rootView.findViewById(R.id.button3);
            final Button button4 = (Button) rootView.findViewById(R.id.button4);
            final Button button5 = (Button) rootView.findViewById(R.id.button5);
            final Button button6 = (Button) rootView.findViewById(R.id.button6);
            final Button button7 = (Button) rootView.findViewById(R.id.button7);
            final Button button8 = (Button) rootView.findViewById(R.id.button8);

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.getCollectionService().getCollection("climbatize", new Callback<ItemList>() {
                        @Override
                        public void success(ItemList itemList, Response response) {
                            textView.setText(itemList.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });
                }
            });

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.connect("climbatize", null, PlaceholderFragment.this.getActivity(), new Callback<Boolean>() {
                        @Override
                        public void success(Boolean aBoolean, Response response) {
                            textView.setText(aBoolean ? "connexion OK" : "connexion KO");
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.getGalleryService().getGalleryForUser("climbatize", 0, new Callback<PictureGallery>() {
                        @Override
                        public void success(PictureGallery pictureGallery, Response response) {
                            textView.setText(pictureGallery.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.wishFigure("166816", 5, MFCRequest.STATUS.WISHED, PlaceholderFragment.this.getActivity().getApplicationContext(), new Callback<MFCRequest.MANAGECOLLECTION>() {
                        @Override
                        public void success(MFCRequest.MANAGECOLLECTION managecollection, Response response) {
                            textView.setText(managecollection.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.orderFigure("166816",1,10,"test", MFCRequest.SHIPPING.SAL,"test",new ItemDate(new Date()),null, MFCRequest.SUBSTATUS.NA, MFCRequest.STATUS.WISHED,getActivity().getApplicationContext(),new Callback<MFCRequest.MANAGECOLLECTION>() {
                        @Override
                        public void success(MFCRequest.MANAGECOLLECTION managecollection, Response response) {
                            textView.setText(managecollection.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });

                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.ownFigure("166816", 1, new ItemDate(new Date()),8,10, "test", MFCRequest.SHIPPING.SAL, "test", new ItemDate(new Date()), null, MFCRequest.SUBSTATUS.NA, MFCRequest.STATUS.WISHED, getActivity().getApplicationContext(), new Callback<MFCRequest.MANAGECOLLECTION>() {
                        @Override
                        public void success(MFCRequest.MANAGECOLLECTION managecollection, Response response) {
                            textView.setText(managecollection.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });

                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.deleteFigure("166816", MFCRequest.STATUS.WISHED, getActivity().getApplicationContext(), new Callback<MFCRequest.MANAGECOLLECTION>() {
                        @Override
                        public void success(MFCRequest.MANAGECOLLECTION managecollection, Response response) {
                            textView.setText(managecollection.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });

                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.getSearchService().search("test", new Callback<SearchResult>() {
                        @Override
                        public void success(SearchResult itemList, Response response) {
                            textView.setText(itemList.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MFCRequest.INSTANCE.getUserService().getUser("climbatize", new Callback<UserProfile>() {
                        @Override
                        public void success(UserProfile itemList, Response response) {
                            textView.setText(itemList.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });
                }
            });

            return rootView;
        }
    }
}
