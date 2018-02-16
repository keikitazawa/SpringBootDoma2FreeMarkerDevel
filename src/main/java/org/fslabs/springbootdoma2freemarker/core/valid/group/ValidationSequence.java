package org.fslabs.springbootdoma2freemarker.core.valid.group;

import javax.validation.GroupSequence;

@GroupSequence({EntryValidation.class, StyleValidation.class, MultipleValidation.class})
public interface ValidationSequence {

}
