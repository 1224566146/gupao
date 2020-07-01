package com.fan.gupao.bridge.course;

/**
 * @author 樊高风
 * @date 2020/7/1
 */
public class AbstractCourse implements ICourse {

    private INote note;

    private IVideo video;

    public INote getNote() {
        return note;
    }

    public void setNote(INote note) {
        this.note = note;
    }

    public IVideo getVideo() {
        return video;
    }

    public void setVideo(IVideo video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "AbstractCourse{" +
                "note=" + note +
                ", video=" + video +
                '}';
    }
}
