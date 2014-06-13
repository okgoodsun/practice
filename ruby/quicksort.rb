
class Array

  def quicksort!(range_s = 0, range_e = self.size - 1)
    i = range_s
    j = range_e

    # validate the inputs
    raise ArgumentError, "#{j} < #{i}" if j < i

    # no sorting needed if empty or only 1 item to sort
    return if self[i..j].size < 2

    x = self[i] # set value for comparison
    moving_j = true
    while i < j
      if moving_j
        if self[j] < x
          self[i] = self[j]
          i += 1
          moving_j = false
        else
          j -= 1
        end
      else
        if self[i] > x
          self[j] = self[i]
          j -= 1
          moving_j = true
        else
          i += 1
        end
      end
    end
    self[i] = x # set back the value for comparison

    # sort the rest of left part
    quicksort!(range_s, i - 1) if i > range_s

    # sort the rest of right part
    quicksort!(i + 1, range_e) if i < range_e

    self
  end

end

puts [5, 9, 2, 4, 0, 1, 8, 7].quicksort!
