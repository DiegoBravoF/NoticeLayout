package com.dive.notice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class NoticeLayout extends LinearLayout {
    public final static int SLIDERIGHT = 0;
    public final static int SLIDELEFT = 1;
    public final static int SLIDETOP = 2;
    public final static int SLIDEBOTTOM = 3;
    public final static int FADE = 4;
    private int animacionOut = 4;
    private int animacionIn = 4;


    LayoutInflater inflater;
    String title;
    String content;
    String acceptText;
    String cancelText;
    TextView tvTittle;
    TextView tvContent;
    ImageView imgNotice;
    ProgressBar pgbNotice;
    Button accept;
    RelativeLayout rlyNotice;
    LinearLayout rlyNoticeSmall;
    Button cancel;
    boolean cancelButton = true;
    boolean acceptButton = true;
    boolean fullScreen = true;
    Drawable imgResource;
    Drawable acceptBackground;
    Drawable cancelBackground;
    int tittleColor = - 1;
    int contentColor = - 1;
    int acceptColor = - 1;
    int cancelColor = - 1;
    Animation animation;

    public NoticeLayout(Context context) {
        super(context);
        if (! isInEditMode()) {
            initView();
        }

    }

    public NoticeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (! isInEditMode()) {

            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.NoticeLayout);

            final int N = a.getIndexCount();
            for (int i = 0; i < N; ++ i) {
                int attr = a.getIndex(i);

                if (R.styleable.NoticeLayout_acceptText == attr) {
                    acceptText = a.getString(attr);
                }

                if (R.styleable.NoticeLayout_cancelText == attr) {
                    cancelText = a.getString(attr);
                }

                if (R.styleable.NoticeLayout_tittleText == attr) {
                    title = a.getString(attr);
                }

                if (R.styleable.NoticeLayout_contentText == attr) {
                    content = a.getString(attr);
                }

                if (R.styleable.NoticeLayout_cancelButton == attr) {
                    cancelButton = a.getBoolean(attr, true);
                }


                if (R.styleable.NoticeLayout_acceptButton == attr) {
                    acceptButton = a.getBoolean(attr, true);
                }

                if (R.styleable.NoticeLayout_acceptColor == attr) {
                    acceptColor = a.getColor(attr, getResources().getColor(android.R.color.white));
                }


                if (R.styleable.NoticeLayout_cancelColor == attr) {
                    cancelColor = a.getColor(attr, getResources().getColor(android.R.color.white));
                }


                if (R.styleable.NoticeLayout_imgNotice == attr) {
                    imgResource = a.getDrawable(attr);
                }

                if (R.styleable.NoticeLayout_acceptBackground == attr) {
                    acceptBackground = a.getDrawable(attr);
                }

                if (R.styleable.NoticeLayout_cancelBackground == attr) {
                    cancelBackground = a.getDrawable(attr);
                }

                if (R.styleable.NoticeLayout_fullScreen == attr) {
                    fullScreen = a.getBoolean(attr, true);
                }

                if (R.styleable.NoticeLayout_tittleColor == attr) {
                    tittleColor = a.getColor(attr, getResources().getColor(android.R.color.white));
                }

                if (R.styleable.NoticeLayout_contentColor == attr) {
                    contentColor = a.getColor(attr, getResources().getColor(android.R.color.white));
                }


                if (R.styleable.NoticeLayout_animIn == attr) {
                    animacionIn = a.getInt(attr, - 1);
                }

                if (R.styleable.NoticeLayout_animOut == attr) {
                    animacionOut = a.getInt(attr, - 1);
                }
            }

            a.recycle();

            initView();
        }
    }

    private void initView() {

        if (! fullScreen) {
            ((Activity) getContext()).getLayoutInflater().inflate(R.layout.notice_small_layout, this, true);
            rlyNoticeSmall = (LinearLayout) findViewById(R.id.rlyNoticeSmall);
        } else {
            ((Activity) getContext()).getLayoutInflater().inflate(R.layout.notice_layout, this, true);

        }
        accept = (Button) findViewById(R.id.btnOKNotice);
        cancel = (Button) findViewById(R.id.btnKONotice);
        tvTittle = (TextView) findViewById(R.id.lblNoticeTitle);
        tvContent = (TextView) findViewById(R.id.lblNotice);
        imgNotice = (ImageView) findViewById(R.id.imgNotice);
        rlyNotice = (RelativeLayout) findViewById(R.id.rlyNotice);
        pgbNotice = (ProgressBar) findViewById(R.id.pgbNotice);

        tvTittle.setText(title);
        tvContent.setText(content);
        accept.setText(acceptText);
        cancel.setText(cancelText);
        if (tittleColor != - 1) {
            tvTittle.setTextColor(tittleColor);
        }
        if (contentColor != - 1) {
            tvContent.setTextColor(contentColor);
        }
        if (acceptColor != - 1) {
            accept.setTextColor(acceptColor);
        }
        if (cancelColor != - 1) {
            cancel.setTextColor(cancelColor);
        }
        if (tittleColor != - 1) {
            tvTittle.setTextColor(tittleColor);
        }
        if (imgResource != null) {
            imgNotice.setImageDrawable(imgResource);
        }
        if (acceptBackground != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                accept.setBackground(acceptBackground);
            } else {
                accept.setBackgroundDrawable(acceptBackground);
            }
        }
        if (cancelBackground != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                cancel.setBackground(cancelBackground);
            } else {
                accept.setBackgroundDrawable(cancelBackground);
            }
        }
        if (! cancelButton) {
            cancel.setVisibility(GONE);
        }
        if (! acceptButton) {
            accept.setVisibility(GONE);
        }
    }

    public Button getAcceptButton() {
        return accept;
    }

    public TextView getTitle() {
        return tvTittle;
    }

    public TextView getMessage() {
        return tvContent;
    }

    public Button getCancelButton() {
        return cancel;
    }

    public void setVisibilityProgressWheel(boolean toShow) {
        pgbNotice.setVisibility(toShow ? VISIBLE : GONE);
    }

    public void setAcceptButtonBackground(int acceptBackground) {
        this.accept.setBackgroundResource(acceptBackground);
    }

    public void setCancelButtonBackground(int cancelBackground) {
        this.cancel.setBackgroundResource(cancelBackground);
    }


    public boolean isShowed() {
        if (fullScreen) {
            return (this.rlyNotice.getVisibility() == View.VISIBLE);
        } else {
            return (this.rlyNoticeSmall.getVisibility() == View.VISIBLE);
        }
    }

    public boolean isVisible() {
        if (fullScreen) {
            return rlyNotice.getVisibility() == View.VISIBLE;
        } else {
            return rlyNoticeSmall.getVisibility() == View.VISIBLE;
        }
    }

    public void show(final boolean toShow) {
        if (toShow) {
            switch (animacionIn) {
                case SLIDERIGHT:
                    animation = new TranslateAnimation(getWidth(), 0, 0, 0);
                    break;
                case SLIDELEFT:
                    animation = new TranslateAnimation(- getWidth(), 0, 0, 0);
                    break;
                case SLIDETOP:
                    animation = new TranslateAnimation(0, 0, - getHeight(), 0);
                    break;
                case SLIDEBOTTOM:
                    animation = new TranslateAnimation(0, 0, getHeight(), 0);
                    break;
                default:
                    animation = new AlphaAnimation((toShow) ? 0 : 1, (toShow) ? 1 : 0);
                    break;
            }
        } else {
            switch (animacionOut) {
                case SLIDERIGHT:
                    animation = new TranslateAnimation(0, getWidth(), 0, 0);
                    break;
                case SLIDELEFT:
                    animation = new TranslateAnimation(0, - getWidth(), 0, 0);
                    break;
                case SLIDETOP:
                    animation = new TranslateAnimation(0, 0, 0, - getHeight());
                    break;
                case SLIDEBOTTOM:
                    animation = new TranslateAnimation(0, 0, 0, getHeight());
                    break;
                default:
                    animation = new AlphaAnimation((toShow) ? 0 : 1, (toShow) ? 1 : 0);
                    break;
            }
        }

        AlphaAnimation alphaAnimation = new AlphaAnimation((toShow) ? 0 : 1, (toShow) ? 1 : 0);
        alphaAnimation.setDuration(200);
        animation.setDuration(200);

        if (! fullScreen) {
            if (toShow) {
                rlyNoticeSmall.setVisibility(View.VISIBLE);
            }
            rlyNoticeSmall.startAnimation(alphaAnimation);
        } else {
            if (toShow) {
                rlyNotice.setVisibility(View.VISIBLE);
            }
        }

        rlyNotice.startAnimation(animation);
        animation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (! fullScreen) {
                    if (! toShow) {
                        rlyNoticeSmall.setVisibility(View.GONE);
                    }
                } else {
                    if (! toShow) {
                        rlyNotice.setVisibility(View.GONE);
                    }
                }
            }
        });

    }
}
