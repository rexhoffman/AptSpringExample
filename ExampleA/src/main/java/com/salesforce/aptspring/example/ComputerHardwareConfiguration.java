/*
 * Copyright © 2017, Saleforce.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.salesforce.aptspring.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.salesforce.aptspring.Verified;
import com.salesforce.aptspring.example.objects.ItemType;

@Verified(expectedBeans = {"valueBean"})
@Configuration
public class ComputerHardwareConfiguration {

  @Bean("hardware_root")
  public ItemType getComputerHardware(@Qualifier("drives") ItemType drives) {
    ItemType root1 = new ItemType("Computer Hardware");
    root1.addSubType(drives);
    return root1;
  }
  
  @Bean("drives")
  public ItemType getStorage(@Qualifier("drive_items") List<ItemType> driveItems, @Qualifier("valueBean") String bean) {
    ItemType drives = new ItemType("Storage");
    driveItems.stream().forEach(item -> drives.addSubType(item));
    return drives;
  }
  
  @Bean("drive_items")
  public List<ItemType> getHardDriveTypes(@Qualifier("drives_ssd") ItemType ssd,
      @Qualifier("drives_platters") ItemType mechanical) {
    return Collections.unmodifiableList(Arrays.asList(ssd, mechanical));
  }
  
  @Bean("drives_ssd")
  public ItemType getSolidStateDrive() {
    return new ItemType("SSD");
  }

  @Bean("drives_platters")
  public ItemType getPlatters() {
    return new ItemType("Mechanical");
  }
  
}
