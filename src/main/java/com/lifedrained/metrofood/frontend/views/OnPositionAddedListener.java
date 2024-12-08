package com.lifedrained.metrofood.frontend.views;

import com.lifedrained.metrofood.data.repo.entity.Position;

public interface OnPositionAddedListener {
    void onPositionAdded(Position position, int count);
}
